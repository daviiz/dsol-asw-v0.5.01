package combatSysModel.DEM;

import combatSysModel.OM.ObjectModelBase;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public abstract class CoupledModelBase<om extends ObjectModelBase> extends CoupledModel.TimeDouble implements IDEVSModel{

    public CoupledModelBase(String modelName) { super(modelName); }

    public CoupledModelBase(String modelName, TimeDouble parentModel) { super(modelName, parentModel); }

    public CoupledModelBase(String modelName, DEVSSimulatorInterface.TimeDouble simulator) { super(modelName, simulator); }

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
