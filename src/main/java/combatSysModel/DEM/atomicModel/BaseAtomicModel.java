package combatSysModel.DEM.atomicModel;

import combatSysModel.DEM.IDEVSModel;
import combatSysModel.OM.ObjectModelBase;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.AtomicModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

/**
 *
 */
public abstract class BaseAtomicModel<OMType extends ObjectModelBase> extends AtomicModel<Double, Double, SimTimeDouble> implements IDEVSModel {

    OMType om;

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
     * 原子模型外部函数实现，
     * 接收外部输入，无需考虑仿真事件时间推进，专注于业务逻辑
     *
     * @param value
     */
    protected abstract void deltaExternalFunc(Object value);

    /**
     * 原子模型内部函数实现
     */
    protected abstract void deltaInternalFunc();

    public BaseAtomicModel(String modelName, CoupledModel.TimeDouble parentModel) {
        super(modelName, parentModel);
    }

    public BaseAtomicModel(String modelName, DEVSSimulator.TimeDouble simulator) {
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
