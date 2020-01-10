package com.example.modelviewpresenter.Network;

import android.net.NetworkInfo;

public interface DownloadCallback {
    interface Progress {
        int ERROR = -1;
        int CONNECT_SUCCESS = 0;
        int GET_INPUT_STREAM_SUCCESS = 1;
        int PROCESS_INPUT_STREAM_IN_PROGRESS = 2;
        int PROCESS_INPUT_STREAM_SUCCESS = 3;
    }

    /**
     * Get the device's active network status in the form of a NetworkInfo object.
     */
    NetworkInfo getActiveNetworkInfo();

    /**
     * Indicate to callback handler any progress update.
     * @param progressCode must be one of the constants defined in DownloadCallback.Progress.
     * @param percentComplete must be 0-100.
     */
    void onProgressUpdate(int progressCode, int percentComplete);

    /**
     * Indicates that the download operation has finished. This method is called even if the
     * download hasn't completed successfully.
     */

    String getMail();
    String getRegMail();
    String getRegPassword();

    String getPassword();
    String getAccesstoken();

    //Address
    String getNumber();
    String getZip();
    String getCity();
    String getStreet();
    String getCountry();
    //Personal data
    String getGender();
    String getFirstname();
    String getLastname();
    String getBirthday();
    String getPhone();
}
