package combatSysModel.DEM.atomicModel;

import combatSysModel.OM.OM_Controller;
import combatSysModel.portType.env_info;
import combatSysModel.portType.target_info;
import combatSysModel.portType.threat_info;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.Phase;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Controller_Platform_Updater extends BaseAtomicModel<OM_Controller> {

    public InputPort<Double,Double, SimTimeDouble, threat_info> in_threat_info;
    public InputPort<Double,Double, SimTimeDouble, env_info> in_env_info;

    public OutputPort<Double,Double,SimTimeDouble, target_info> out_target_info;

    private Phase WAIT,IDENTIFICATION;

    private threat_info threat_info;
    private env_info env_info;
    private target_info t;

    @Override
    protected void constructPort() {
        in_threat_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.threat_info>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        out_target_info = new OutputPort<Double, Double, SimTimeDouble, target_info>(this);
    }

    @Override
    protected void constructPhase() {
        WAIT = new Phase("WAIT");
        WAIT.setLifeTime(Double.POSITIVE_INFINITY);
        IDENTIFICATION = new Phase("IDENTIFICATION");
        IDENTIFICATION.setLifeTime(15.0);
        this.phase = WAIT;
    }

    @Override
    protected void constructModelData() {
        threat_info = new threat_info();
        env_info = new env_info();
    }

    @Override
    protected void deltaExternalFunc(Object value) {
        if (this.phase.getName().equals("WAIT")) {
            if (this.activePort == in_env_info) {
                threat_info = (threat_info) value;
            } else if (this.activePort == in_threat_info) {
                env_info = (env_info)value;
                this.phase = IDENTIFICATION;
            }
        }
        else if (this.phase.getName().equals("IDENTIFICATION")) {
            if (this.activePort == in_threat_info) {
                env_info = (env_info)value;
            }
        }
    }

    @Override
    protected void deltaInternalFunc() {
        if(this.phase.getName().equals("WAIT")){
            this.phase = IDENTIFICATION;
            return;
        }
        if(this.phase.getName().equals("IDENTIFICATION")){
            t = this.om.identification(threat_info,env_info);
            return;
        }
    }

    @Override
    protected void lambdaFunc() {
        if(this.phase.getName().equals("IDENTIFICATION")){
            out_target_info.send(t);
        }
    }

    public Controller_Platform_Updater(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Controller_Platform_Updater(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
