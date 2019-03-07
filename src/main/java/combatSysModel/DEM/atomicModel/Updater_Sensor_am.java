package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.Sensor_updater_om;
import combatSysModel.portType.move_result;
import combatSysModel.portType.request;
import combatSysModel.portType.response;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Updater_Sensor_am extends AtomicModelBase<Sensor_updater_om> {

    public InputPort<Double, Double, SimTimeDouble, move_result> in_move_result;
    public InputPort<Double, Double, SimTimeDouble, request> in_request;

    public OutputPort<Double, Double, SimTimeDouble, response> out_response;


    public Updater_Sensor_am(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Updater_Sensor_am(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    protected void constructPort() {

    }

    @Override
    protected void constructPhase() {

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
}
