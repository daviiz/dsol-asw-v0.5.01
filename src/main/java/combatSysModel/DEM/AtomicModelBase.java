package combatSysModel.DEM;

import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.AtomicModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.CoupledModel;
import nl.tudelft.simulation.dsol.formalisms.devs.ESDEVS.Phase;
import nl.tudelft.simulation.dsol.simtime.SimTimeDouble;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulator;

/**
 *模型开发：命名规范：
 * 原子模型：按照模型耦合层次由内而外命名，如：Actor_Controller_Platform_am
 * 耦合模型：按照模型耦合层次由内而外命名，如：Controller_Platform_cm
 *
 * 原子模型二次开发注意：
 * 1.原子模型DEM与OM是配套成对存在的，在DEM中InputPort & OutputPort 中定义的 PortType 具体类型的参数，必须在对应OM中定义为成员变量，
 *   这么做的目的是：实现单一职责原则，DEM只负责原子模型中业务流程的控制，不涉及任何业务计算和数据，OM仅负责模型的具体业务计算；
 * 2.原子模型实例化后必须立即setOM(om)方法，添加OM模型；
 */
public abstract class AtomicModelBase<OMType extends ObjectModelBase> extends AtomicModel<Double, Double, SimTimeDouble> implements IDEVSModel {

    protected OMType om;

    /** the last phase (if applicable). */
    protected Phase lastPhase = new Phase("");

    @Override
    protected void deltaInternal() {
        this.elapsedTime = 0.0;
        deltaInternalFunc();
        this.om.setStatusValid();
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
        //ensure updated message output each simulation frame:
        if(this.om.status){
            lambdaFunc();
        }
        this.om.setStatusInvalid();
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
    //protected abstract void constructModelData();

    /**
     * 原子模型外部函数，
     * 接收外部输入，无需考虑仿真事件时间推进，专注于业务逻辑
     * 外部转换函数一般用于：
     * 1.接收输入；
     * 2.模型状态跳转控制
     * 3.调用OM实现业务模型逻辑
     * @param value
     */
    protected abstract void deltaExternalFunc(Object value);

    /**
     * 原子模型内部函数
     * 一般用于：
     * 调用OM实现业务模型逻辑
     */
    protected abstract void deltaInternalFunc();

    /**
     * 原子模型-输出函数：
     * 一般用于实现
     * 1.模型输出；
     * 2.模型状态跳转控制
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
        //constructModelData();
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
