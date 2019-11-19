package Controller;


import javafx.concurrent.Task;

public abstract class ProgressBarController extends Task<Integer> {


    @Override
    protected Integer call() throws Exception {

        for (int i = 10; i <= 100; i++){

            updateProgress(i, 100);
            Thread.sleep(200);

        }

        return 100;

    }

    @Override
    protected void updateProgress(double workDone, double max) {

        long loading = Math.round(workDone);

        if (loading >= 13 && loading <= 24){

            updateMessage("Starting up the system");

        } else if (loading >= 39 && loading <= 70){

            updateMessage("Fetching data..");

            try {

                createCache();

            } catch (Exception e){

                System.out.println("Error creating cache");

            }

        } else if (loading >= 99){

            updateMessage("Welcome to Chick-4-All");

        } else {

            updateMessage("Loading: " + (loading) + "%");

        }

        super.updateProgress(workDone, max);

    }


    public abstract void createCache();

}
