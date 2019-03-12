package combatSysModel.main;

import combatSysModel.DEM.coupledModel.ASW_CM;
import nl.tudelft.simulation.dsol.model.AbstractDSOLModel;
import nl.tudelft.simulation.dsol.simulators.DEVSSimulatorInterface;

public class ASWModel6 extends AbstractDSOLModel.TimeDouble<DEVSSimulatorInterface.TimeDouble> {

    public ASWModel6(final DEVSSimulatorInterface.TimeDouble simulator) {
        super(simulator);
    }

    @Override
    public void constructModel() /* throws SimRuntimeException */ {

        //模型初始化：
        //ModelData f1Data = new ModelData("Fleet");
        //f1Data.origin = f1Data.destination = new CartesianPoint(-200, -50, 0);
        //ModelData s1Data = new ModelData("Submarine");
        //s1Data.origin = s1Data.destination = new CartesianPoint(200, 100, 0);

        ASW_CM root = new ASW_CM("");
        root.setSimulator(this.simulator);
        root.constructModel();


//        try {
//            Visual2dService.getInstance().register(f1Data.name, simulator, f1Data);
//            //Visual2dService.getInstance().register(s1Data.name, simulator, s1Data);
//
//        } catch (NamingException e) {
//            SimLogger.always().error(e);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }
}
