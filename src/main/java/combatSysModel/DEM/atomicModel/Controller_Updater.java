package combatSysModel.DEM.atomicModel;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Controller_Updater extends AtomicModelBase {



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

    public Controller_Updater(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public Controller_Updater(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }
}
