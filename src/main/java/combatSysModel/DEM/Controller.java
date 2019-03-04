package combatSysModel.DEM;

import combatSysModel.BasedCoupledModel;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class Controller extends BasedCoupledModel {

    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.threat_info> in_threat_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_finished> in_move_finished;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.fuel_exhausted> in_fuel_exhausted;

    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.wp_launch> out_wp_launch;
    public OutputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_cmd> out_move_cmd;

    public Controller(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    public Controller(String modelName) {
        super(modelName);
    }

    public Controller(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    @Override
    public void constructModel() {
        /**
         * X
         */
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        in_threat_info = new InputPort<Double, Double, SimTimeDouble, threat_info>(this);
        in_move_finished = new InputPort<Double, Double, SimTimeDouble, move_finished>(this);
        in_fuel_exhausted = new InputPort<Double, Double, SimTimeDouble, fuel_exhausted>(this);
        /**
         * Y
         */
        out_wp_launch = new OutputPort<Double, Double, SimTimeDouble, wp_launch>(this);
        out_move_cmd = new OutputPort<Double, Double, SimTimeDouble, move_cmd>(this);

    }

}
