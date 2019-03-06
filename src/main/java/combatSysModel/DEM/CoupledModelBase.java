package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public abstract class CoupledModelBase extends CoupledModel.TimeDouble implements IDEVSModel{

    public CoupledModelBase(String modelName) { super(modelName); }

    public CoupledModelBase(String modelName, TimeDouble parentModel) { super(modelName, parentModel); }

    public CoupledModelBase(String modelName, DEVSSimulatorInterface.TimeDouble simulator) { super(modelName, simulator); }

    /**
     * construct input and output port
     */
    protected abstract void constructPort();
    /**
     *  coupling relation construction
     */
    protected abstract void couplingComponent();

    /**
     * unify the coupling structure's construct code
     */
    @Override
    public void constructModel() {
        constructPort();
        couplingComponent();
    }
}
