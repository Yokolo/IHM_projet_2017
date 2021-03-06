package com.a2017.ihm.m2gi.maisonconnecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.TextView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.Features2d;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ACG on 29/11/2017.
 */

public class ReconnaissanceGesteActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    private static final String TAG = "OCVSample::Activity";
    private int w, h;
    private CameraBridgeViewBase mOpenCvCameraView;
    TextView tvName;
    Scalar RED = new Scalar(255, 0, 0);
    Scalar GREEN = new Scalar(0, 255, 0);
    FeatureDetector detector;
    DescriptorExtractor descriptor;
    DescriptorMatcher matcher;
    Mat descriptorsimg2,descriptorsimg1,descriptorsimg3,descriptorsinput;
    Mat img1,img2,img3;
    MatOfKeyPoint keypointsimg1,keypointsimg2,keypointsimg3,keypointsinput;
    int nbreco =0;
    long begin =0;

    static {
        if (!OpenCVLoader.initDebug())
            Log.d("ERROR", "Unable to load OpenCV");
        else
            Log.d("SUCCESS", "OpenCV loaded");
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    Log.i(TAG, "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                    try {
                        initializeOpenCVDependencies();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
                default: {
                    super.onManagerConnected(status);
                }
                break;
            }
        }
    };

    private void initializeOpenCVDependencies() throws IOException {
        mOpenCvCameraView.enableView();
        detector = FeatureDetector.create(FeatureDetector.ORB);
        descriptor = DescriptorExtractor.create(DescriptorExtractor.ORB);
        matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_HAMMING);
        img1 = new Mat();
        AssetManager assetManager = getAssets();
        InputStream istr = assetManager.open("pig.jpg");
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        Utils.bitmapToMat(bitmap, img1);
        Imgproc.cvtColor(img1, img1, Imgproc.COLOR_RGB2GRAY);
        img1.convertTo(img1, 0); //converting the image to match with the type of the cameras image

        descriptorsimg1 = new Mat();
        keypointsimg1 = new MatOfKeyPoint();
        detector.detect(img1, keypointsimg1);
        descriptor.compute(img1, keypointsimg1, descriptorsimg1);

        Log.d("finito","j'ai fini l'init");

    }


    public ReconnaissanceGesteActivity() {

        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "called onCreate");
        nbreco = 0;
        begin=0;
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_reconnaissance_geste);
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.tutorial1_activity_java_surface_view);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
        tvName = (TextView) findViewById(R.id.text1);

    }

    @Override
    public void onPause() {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
        w = width;
        h = height;
    }

    public void onCameraViewStopped() {
    }

    public Mat recognize(Mat aInputFrame) {

        Imgproc.cvtColor(aInputFrame, aInputFrame, Imgproc.COLOR_RGB2GRAY);
        descriptorsinput = new Mat();
        keypointsinput = new MatOfKeyPoint();
        detector.detect(aInputFrame, keypointsinput);
        descriptor.compute(aInputFrame, keypointsinput, descriptorsinput);

        // Matching
        MatOfDMatch matches = new MatOfDMatch();
        if (img1.type() == aInputFrame.type()) {
            matcher.match(descriptorsimg1, descriptorsinput, matches);
        } else {
            return aInputFrame;
        }
        List<DMatch> matchesList = matches.toList();

        Double max_dist = 0.0;
        Double min_dist = 100.0;

        for (int i = 0; i < matchesList.size(); i++) {
            Double dist = (double) matchesList.get(i).distance;
            if (dist < min_dist)
                min_dist = dist;
            if (dist > max_dist)
                max_dist = dist;
        }

        LinkedList<DMatch> good_matches = new LinkedList<DMatch>();
        for (int i = 0; i < matchesList.size(); i++) {
            if (matchesList.get(i).distance <= (1.5 * min_dist))
                good_matches.addLast(matchesList.get(i));
        }


        if(good_matches.size()<10){
            Log.d("YEEEEEES","JE SUIS EN ATTENTE");
            if(nbreco==0){
                begin = System.currentTimeMillis();
                nbreco++;
            }
            else {
                if(System.currentTimeMillis()-begin<5000){
                    if(nbreco<5){
                        Log.d("YEEEEEES","IMAGE PRESQUE DETECTE "+ Long.toString(System.currentTimeMillis()-begin));
                        nbreco++;
                    }
                    else {
                        Log.d("YEEEEEES","IMAGE DETECTE");
                        LumiereActivity.isLumiereCouranteOn = !LumiereActivity.isLumiereCouranteOn;
                        Intent intent = new Intent(this, LumiereActivity.class);
                        startActivity(intent);
                    }
                }
                else {
                    nbreco=0;
                }
            }
        }

        MatOfDMatch goodMatches = new MatOfDMatch();
        goodMatches.fromList(good_matches);
        Mat outputImg = new Mat();
        MatOfByte drawnMatches = new MatOfByte();
        if (aInputFrame.empty() || aInputFrame.cols() < 1 || aInputFrame.rows() < 1) {
            return aInputFrame;
        }
        Features2d.drawMatches(img1, keypointsimg1, aInputFrame, keypointsimg1, goodMatches, outputImg, GREEN, RED, drawnMatches, Features2d.DRAW_RICH_KEYPOINTS);
        Imgproc.resize(outputImg, outputImg, aInputFrame.size());
        Log.d("cassos","je me casse");
        return outputImg;
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
            return recognize(inputFrame.rgba());
    }
}
