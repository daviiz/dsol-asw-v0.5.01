package combatSysModel.DEM.atomicModel;

import combatSysModel.OM.OM_Controller;
import combatSysModel.portType.scen_info;
import combatSysModel.portType.target_info;
import combatSysModel.portType.threat_info;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.Phase;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Controller_Updater extends BaseAtomicModel<OM_Controller> {

    public InputPort<Double,Double, SimTimeDouble, threat_info> in_threat_info;
    public InputPort<Double,Double, SimTimeDouble, scen_info> in_scen_info;

    public OutputPort<Double,Double,SimTimeDouble, target_info> out_target_info;

    private Phase WAIT,IDENTIFICATION;

    private threat_info threat_info;
    private scen_info scen_info;
    private target_info t;

    @Override
    void constructPort() {
        in_threat_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.threat_info>(this);
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info>(this);
        out_target_info = new OutputPort<Double, Double, SimTimeDouble, target_info>(this);
    }

    @Override
    void constructPhase() {
        WAIT = new Phase("WAIT");
        WAIT.setLifeTime(Double.POSITIVE_INFINITY);
        IDENTIFICATION = new Phase("IDENTIFICATION");
        IDENTIFICATION.setLifeTime(15.0);
        this.phase = WAIT;
    }

    @Override
    void constructModelData() {
        threat_info = new threat_info();
        scen_info = new scen_info();
    }

    @Override
    void deltaExternalFunc(Object value) {
        if (this.phase.getName().equals("WAIT")) {
            if (this.activePort == in_scen_info) {
                threat_info = (threat_info) value;
            } else if (this.activePort == in_threat_info) {
                scen_info = (scen_info)value;
                this.phase = IDENTIFICATION;
            }
        }
        else if (this.phase.getName().equals("IDENTIFICATION")) {
            if (this.activePort == in_threat_info) {
                scen_info = (scen_info)value;
            }
        }
    }

    @Override
    void deltaInternalFunc() {
        if(this.phase.getName().equals("WAIT")){
            this.phase = IDENTIFICATION;
            return;
        }
        if(this.phase.getName().equals("IDENTIFICATION")){
            t = this.om.identification(threat_info,scen_info);
            return;
        }
    }

    @Override
    protected void lambda() {
        if(this.phase.getName().equals("IDENTIFICATION")){
            out_target_info.send(t);
        }
    }

    public Controller_Updater(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Controller_Updater(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
