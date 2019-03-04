package combatSysModel.DEM.atomicModel;

import combatSysModel.OM.OM_Controller;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Controller_Actor extends AtomicModelBase<OM_Controller> {
    @Override
    void constructPort() {

    }

    @Override
    void constructPhase() {

    }

    @Override
    void constructModelData() {

    }

    @Override
    void deltaExternalFunc(Object value) {

    }

    @Override
    void deltaInternalFunc() {

    }

    @Override
    protected void lambda() {

    }

    public Controller_Actor(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Controller_Actor(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
