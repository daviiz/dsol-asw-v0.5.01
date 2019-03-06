package combatSysModel.DEM.coupledModel;

import combatSysModel.DEM.CoupledModelBase;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class Maneuver extends CoupledModelBase {

    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info> in_guidance_info;
    public InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.move_cmd> in_move_cmd;

    public OutputPort<Double, Double, SimTimeDouble, move_result> out_move_result;
    public OutputPort<Double, Double, SimTimeDouble, wp_guidance> out_wp_guidance;
    public OutputPort<Double, Double, SimTimeDouble, move_finished> out_move_finished;
    public OutputPort<Double, Double, SimTimeDouble, fuel_exhausted> out_fuel_exhausted;


    public Maneuver(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    public Maneuver(String modelName) {
        super(modelName);
    }

    public Maneuver(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    @Override
    protected void constructPort() {
        /**
         * X
         */
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.scen_info>(this);
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.engage_result>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.env_info>(this);
        in_guidance_info = new InputPort<Double, Double, SimTimeDouble, combatSysModel.portType.guidance_info>(this);
        in_move_cmd = new InputPort<Double, Double, SimTimeDouble, move_cmd>(this);
        /**
         * Y
         */
        out_move_result = new OutputPort<Double, Double, SimTimeDouble, move_result>(this);
        out_wp_guidance = new OutputPort<Double, Double, SimTimeDouble, wp_guidance>(this);
        out_move_finished = new OutputPort<Double, Double, SimTimeDouble, move_finished>(this);
        out_fuel_exhausted = new OutputPort<Double, Double, SimTimeDouble, fuel_exhausted>(this);
    }

    @Override
    protected void couplingComponent() {

    }
}
