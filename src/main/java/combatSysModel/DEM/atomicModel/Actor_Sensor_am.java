package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.OM_Sensor;
import combatSysModel.portType.*;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Actor_Sensor_am extends AtomicModelBase<OM_Sensor> {

    public InputPort<Double, Double, SimTimeDouble, engage_result> in_engage_result;
    public InputPort<Double,Double, SimTimeDouble, env_info> in_env_info;
    public InputPort<Double,Double, SimTimeDouble, scen_info> in_scen_info;
    public InputPort<Double, Double, SimTimeDouble, response> in_response;

    public OutputPort<Double, Double, SimTimeDouble, threat_info> out_threat_info;
    public OutputPort<Double, Double, SimTimeDouble, request> out_request;


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

    public Actor_Sensor_am(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Actor_Sensor_am(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
