package combatSysModel;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public abstract class BasedCoupledModel extends CoupledModel.TimeDouble {

    public BasedCoupledModel(String modelName) {
        super(modelName);
    }

    public BasedCoupledModel(String modelName, TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public BasedCoupledModel(String modelName, DEVSSimulatorInterface.TimeDouble simulator) {
        super(modelName, simulator);
    }

    /**
     * unify the coupling structure's construct code
     */
    public abstract void constructModel();
}
