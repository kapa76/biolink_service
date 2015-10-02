package com.biolink.biometrics2;


/**
 * Base class for all BSDK classes.
 */
public class Ref {
    public int _handle;

    protected int _score;

    protected void checkResult(int result) throws Exception {
        if (result != 0) {
            String msg;
            switch (result) {
                case -12:
                    msg = "No BSDK License";
                    break;
                case -3:
                    msg = "Not Supported Exception";
                    break;
                case -2:
                    msg = "Invalid Argument Exception";
                    break;
                case -4:
                    msg = "Out Of Range Exception";
                    break;
                case -202:
                    msg = "Scan Connect Exception";
                    break;
                default:
                    msg = "BSDK Exception! Error: " + String.valueOf(result);
                    break;
            }

            throw new Exception(msg);
        }
    }

    protected int checkResultLicense(int result) throws Exception {
        if ((result != 0) && (result != -12))
            throw new Exception("BSDK Exception! Error: " + String.valueOf(result));
        return result;
    }

    static {
        System.loadLibrary("bsdk6x_jni");
    }

    private native void DestroyObject(int object);

    /**
     * Destroys any BSDK object.
     */
    public void dispose() {
        DestroyObject(this._handle);
    }

}

