package combatSysModel.DEM;

import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class Controller_Weapon extends BaseCoupledModel {

    public InputPort<Double, Double, SimTimeDouble, engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.threat_info> in_threat_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_finished> in_move_finished;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_guidance> in_wp_guidance;

    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_cmd> out_move_cmd;

    public Controller_Weapon(String modelName) {
        super(modelName);
    }

    public Controller_Weapon(String modelName, TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Controller_Weapon(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    void constructPort() {
        /**
         * X
         */
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info>(this);
        in_threat_info = new InputPort<Double, Double, SimTimeDouble, threat_info>(this);
        in_move_finished = new InputPort<Double, Double, SimTimeDouble, move_finished>(this);
        in_wp_guidance = new InputPort<Double, Double, SimTimeDouble, wp_guidance>(this);
        /**
         * Y
         */
        out_move_cmd = new OutputPort<Double, Double, SimTimeDouble, move_cmd>(this);
    }

    @Override
    void couplingComponent() {

    }
}
