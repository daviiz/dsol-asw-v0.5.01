package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.OM_Maneuver;
import combatSysModel.portType.cmd_info;
import combatSysModel.portType.move_cmd;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Maneuver_Updater extends AtomicModelBase<OM_Maneuver> {

    public InputPort<Double, Double, SimTimeDouble, move_cmd> in_move_cmd;

    public OutputPort<Double, Double, SimTimeDouble, cmd_info> out_cmd_info;

    @Override
    protected void constructPort() {
        in_move_cmd = new InputPort<Double, Double, SimTimeDouble, move_cmd>(this);
        out_cmd_info = new OutputPort<Double, Double, SimTimeDouble, cmd_info>(this);
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

    public Maneuver_Updater(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Maneuver_Updater(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
