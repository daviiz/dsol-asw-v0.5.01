package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.OM_Maneuver;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Maneuver_Actor extends AtomicModelBase<OM_Maneuver> {
    public InputPort<Double, Double, SimTimeDouble, engage_result> in_engage_result;
    public InputPort<Double, Double, SimTimeDouble, scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, env_info> in_env_info;
    public InputPort<Double, Double, SimTimeDouble, cmd_info> in_cmd_info;

    public OutputPort<Double, Double, SimTimeDouble, move_finished> out_move_finished;
    public OutputPort<Double, Double, SimTimeDouble, move_result> out_move_result;
    public OutputPort<Double, Double, SimTimeDouble, fuel_exhausted> out_fuel_exhausted;


    @Override
    protected void constructPort() {
        in_engage_result = new InputPort<Double, Double, SimTimeDouble, engage_result>(this);
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, scen_info>(this);
        in_env_info = new InputPort<Double, Double, SimTimeDouble, env_info>(this);
        in_cmd_info = new InputPort<Double, Double, SimTimeDouble, cmd_info>(this);

        out_move_finished = new OutputPort<Double, Double, SimTimeDouble, move_finished>(this);
        out_move_result = new OutputPort<Double, Double, SimTimeDouble, move_result>(this);
        out_fuel_exhausted = new OutputPort<Double, Double, SimTimeDouble, fuel_exhausted>(this);
    }

    @Override
    protected void constructPhase() {

    }

    @Override
    protected void constructModelData() {

    }

    @Override
    protected void deltaExternalFunc(Object value) {

    }

    @Override
    protected void deltaInternalFunc() {

    }

    @Override
    protected void lambdaFunc() {

    }

    public Maneuver_Actor(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Maneuver_Actor(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
