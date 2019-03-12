package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;
/**
 *模型开发：命名规范：
 * 原子模型：按照模型耦合层次由内而外命名，如：Actor_Controller_Platform_am
 * 耦合模型：按照模型耦合层次由内而外命名，如：Controller_Platform_cm
 */
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
     *  根耦合模型此方法为空
     */
    protected abstract void couplingComponent();

    /**
     * unify the coupling structure's construct code
     */
    @Override
    public void constructModel() {
        if(this.parentModel == null){
            couplingComponent();
            constructPort();
        }else{
            constructPort();
            couplingComponent();
        }

    }
}
