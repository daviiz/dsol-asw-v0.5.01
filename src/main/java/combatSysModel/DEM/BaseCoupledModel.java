package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public abstract class BaseCoupledModel extends CoupledModel.TimeDouble implements IDEVSModel{

    public BaseCoupledModel(String modelName) { super(modelName); }

    public BaseCoupledModel(String modelName, TimeDouble parentModel) { super(modelName, parentModel); }

    public BaseCoupledModel(String modelName, DEVSSimulatorInterface.TimeDouble simulator) { super(modelName, simulator); }

    /**
     * construct input and output port
     */
    abstract void constructPort();
    /**
     *  coupling relation construction
     */
    abstract void couplingComponent();

    /**
     * unify the coupling structure's construct code
     */
    @Override
    public void constructModel() {
        constructPort();
        couplingComponent();
    }
}
