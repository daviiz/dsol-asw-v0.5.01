package combatSysModel.main;

import asw.soa.data.ViewData;
import asw.soa.view.Visual2dService;
import combatSysModel.DEM.coupledModel.ASW_CM;
import nl.tudelft.simulation.dsol.logger.SimLogger;
import nl.tudelft.simulation.dsol.model.AbstractDSOLModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;
import nl.tudelft.simulation.language.d3.CartesianPoint;

import javax.naming.NamingException;
import java.rmi.RemoteException;

public class ASWModel6 extends AbstractDSOLModel.TimeDouble<DEVSSimulatorInterface.TimeDouble> {

    public ASWModel6(final DEVSSimulatorInterface.TimeDouble simulator) {
        super(simulator);
    }

    @Override
    public void constructModel() /* throws SimRuntimeException */ {

        /**
         * DSOL内置了统计仿真过程和结果的模块，暂不实现实验帧以及统计模型--DSOL通过xml配置配置结合开发
         */

        //模型数据准备：
        ViewData f1Data = new ViewData("Fleet");
        f1Data.origin = f1Data.destination = new CartesianPoint(-200, -50, 0);
        ViewData s1Data = new ViewData("Submarine");
        s1Data.origin = s1Data.destination = new CartesianPoint(200, 100, 0);
        ViewData[] mData = {f1Data,s1Data};

        /**
         * 模型初始化及构造
         */
        ASW_CM root = new ASW_CM("");
        root.setSimulator(this.simulator);
        root.constructModel();


        /**
         *  可视化组件注册：
         */
        try {
            root.fleet.maneuver.actor.getOm().setViewData(mData[0]);
            root.submarine.maneuver.actor.getOm().setViewData(mData[1]);
            Visual2dService.getInstance().register(mData[0].name, simulator, mData[0]);
            Visual2dService.getInstance().register(mData[1].name, simulator, mData[1]);

        } catch (NamingException e) {
            SimLogger.always().error(e);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
