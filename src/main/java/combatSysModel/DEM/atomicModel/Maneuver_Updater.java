package combatSysModel.DEM.atomicModel;

import combatSysModel.OM.OM_Maneuver;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

public class Maneuver_Updater extends BaseAtomicModel<OM_Maneuver> {
    @Override
    protected void constructPort() {

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