package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.AtomicModelBase;
import combatSysModel.OM.Environment_om;
import combatSysModel.portType.env_info;
import combatSysModel.portType.scen_info;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.InputPort;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.OutputPort;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Environment_am extends AtomicModelBase<Environment_om>{

    public InputPort<Double,Double, SimTimeDouble, scen_info> in_scen_info;
    public OutputPort<Double,Double, SimTimeDouble, env_info> out_env_info;

    @Override
    protected void constructPort() {
        in_scen_info = new InputPort<Double, Double, SimTimeDouble, scen_info>(this);
        out_env_info = new OutputPort<Double, Double, SimTimeDouble, env_info>(this);
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

    public Environment_am(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Environment_am(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
