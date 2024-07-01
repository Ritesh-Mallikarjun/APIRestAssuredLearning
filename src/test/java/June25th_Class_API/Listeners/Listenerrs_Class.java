package June25th_Class_API.Listeners;

import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class Listenerrs_Class implements IExecutionListener, ISuiteListener {
    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        Long startTime= System.currentTimeMillis();
        System.out.println("Start time is "+startTime);
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("onExecutionFinish");
        Long endTime=System.currentTimeMillis();
        System.out.println("End time is "+endTime);
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("on start suite");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("on finish suite");
    }
}
