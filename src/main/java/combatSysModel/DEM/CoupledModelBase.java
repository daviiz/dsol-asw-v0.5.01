package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public abstract class CoupledModelBase extends CoupledModel.TimeDouble {

    public CoupledModelBase(String modelName) { super(modelName); }

    public CoupledModelBase(String modelName, TimeDouble parentModel) { super(modelName, parentModel); }

    public CoupledModelBase(String modelName, DEVSSimulatorInterface.TimeDouble simulator) { super(modelName, simulator); }

    /**
     * unify the coupling structure's construct code
     */
    public void constructModel(){
        constructPort();
        couplingComponent();
    }
    /**
     * construct input and output port
     */
    abstract void constructPort();
    /**
     *  coupling relation construction
     */
    abstract void couplingComponent();

}
