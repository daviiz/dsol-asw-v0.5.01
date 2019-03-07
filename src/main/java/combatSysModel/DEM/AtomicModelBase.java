package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.AtomicModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

/**
 *模型开发：命名规范：
 * 原子模型：按照模型耦合层次由内而外命名，如：Actor_Controller_Platform_am
 * 耦合模型：按照模型耦合层次由内而外命名，如：Controller_Platform_cm
 */
public abstract class AtomicModelBase<OMType> extends AtomicModel<Double, Double, SimTimeDouble> implements IDEVSModel {

    protected OMType om;

    @Override
    protected void deltaInternal() {
        this.elapsedTime = 0.0;
        deltaInternalFunc();
    }

    @Override
    protected void deltaExternal(Double e, Object value) {
        this.elapsedTime += e;
        deltaExternalFunc(value);
    }

    @Override
    protected Double timeAdvance() {
        return this.phase.getLifeTime();
    }

    @Override
    protected void lambda() {
        lambdaFunc();
    }

    /**
     * construct input and output port
     */
    protected abstract void constructPort();

    /**
     * define atomic model's states
     */
    protected abstract void constructPhase();

    /**
     * atomic model's private data initialization
     */
    protected abstract void constructModelData();

    /**
     * 原子模型外部函数，
     * 接收外部输入，无需考虑仿真事件时间推进，专注于业务逻辑
     *
     * @param value
     */
    protected abstract void deltaExternalFunc(Object value);

    /**
     * 原子模型内部函数
     */
    protected abstract void deltaInternalFunc();

    /**
     * 原子模型-输出函数：
     */
    protected abstract void lambdaFunc();



    public AtomicModelBase(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public AtomicModelBase(String modelName, DEVSSimulator.TimeDouble simulator) {
        super(modelName, simulator);
    }

    @Override
    public void constructModel() {
        constructPhase();
        constructPort();
        constructModelData();
        //this.om = (OM)om;
        super.initialize(0.0);
    }
    public OMType getOm() {
        return om;
    }

    public void setOm(OMType om) {
        this.om = om;
    }
}
