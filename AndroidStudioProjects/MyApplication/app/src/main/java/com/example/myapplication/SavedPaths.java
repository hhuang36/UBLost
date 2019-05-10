package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.ar.core.Anchor;
import com.google.ar.core.Anchor.CloudAnchorState;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.Camera;
import com.google.ar.core.Frame;
import com.google.ar.core.Pose;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class SavedPaths extends AppCompatActivity {

    // variables
    private Button btnChoose, btnUpload;
    ImageView imageView;
    Button Gallery;
    Uri filePath;
    final int PICK_IMAGE_REQUEST = 71;
    private ActionBarDrawerToggle menuToggle;
    BottomNavigationView bottomNavigationView;

    // createmap
    private ArFragment arFragment;
    private ArrayList<Anchor> anchorList = new ArrayList<Anchor>();
    private boolean userIsDone = false;
    private Session session;
    private boolean installRequested;

    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_paths);
        imageView = findViewById(R.id.imgView);
        // Firebase Init
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        bottomNavigationView = findViewById(R.id.savedpaths_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.choose:
                        chooseImage();
                        break;
                    case R.id.upload:
                        uploadImage();
                        break;
                    case R.id.gallery_paths:
                        openGallery();
                        break;
                }
                return true;
            }
        });
        // ar session stuff
        if (session == null) {
            try {
                ArCoreApk.getInstance().requestInstall(this, !installRequested);
            } catch (UnavailableUserDeclinedInstallationException e) {
                Context context = getApplicationContext();
                CharSequence text = "You declined ARCore installation. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } catch (UnavailableDeviceNotCompatibleException e) {
                Context context = getApplicationContext();
                CharSequence text = "Your device is incompatible with ARCore. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            Context context = getApplicationContext();
            try {
                session = new Session(context);
//                try {
//                    session.resume();
//                } catch (CameraNotAvailableException e) {
//                    CharSequence text = "Camera is unavailable. :(";
//                    int duration = Toast.LENGTH_SHORT;
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                }
//                Frame frame = session.update();
//                Camera camera = frame.getCamera();
//                TrackingState cameraTrackingState = camera.getTrackingState();
            } catch (UnavailableArcoreNotInstalledException e) {
                CharSequence text = "You haven't installed ARCore. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } catch (UnavailableApkTooOldException e) {
                CharSequence text = "You need to update your ARCore. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } catch (UnavailableSdkTooOldException e) {
                CharSequence text = "Our app's version of ARCore is too old for your version of ARCore. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } catch (UnavailableDeviceNotCompatibleException e) {
                CharSequence text = "Your device is incompatible with ARCore. :(";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            if (!userIsDone) {
                Anchor anchor = hitResult.createAnchor();
                anchorList.add(anchor);
//                Pose pose = anchor.getPose();
//                anchorList.add(session.createAnchor(pose));
//                TrackingState trackstate = session.createAnchor(pose).getTrackingState();
//                if (trackstate == TrackingState.TRACKING) {
//                    Context context = getApplicationContext();
//                    CharSequence text = "This anchor is trackable.";
//                    int duration = Toast.LENGTH_SHORT;
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                }

                ModelRenderable.builder()
                        .setSource(this, Uri.parse(chooseCorrectModel()))
                        .build()
                        .thenAccept(modelRenderable -> addModeltoScene(anchor, modelRenderable))
                        .exceptionally(throwable -> {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(throwable.getMessage())
                                    .show();
                            return null;
                        });
            }
            else {
                Context context = getApplicationContext();
                CharSequence text = "You've already pressed done and completed making your path! To make a new path, please restart the app.";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        // undo button
        Button undoButton = findViewById(R.id.undo_button);
        undoButton.setOnClickListener(
                (unusedView) -> {
                    // undo:
                    // - remove previously saved anchor from anchorList
                    // - remove last anchor + its rendering
                    if (userIsDone) {
                        Context context = getApplicationContext();
                        CharSequence text = "You've already pressed done and completed making your path! You cannot undo the last arrow you put down. To make a new path, please restart the app.";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show(); }
                    else if (anchorList.isEmpty()) {
                        Context context = getApplicationContext();
                        CharSequence text = "You haven't placed down any arrows!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    else {
                        int lastAnchorIndex = anchorList.size() - 1;
                        Anchor lastAnchor = anchorList.remove(lastAnchorIndex);
                        deleteAnchor(lastAnchor);
                    }
                });
        // clear button
        Button clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(
                (unusedView) -> {
                    // clear:
                    // - make anchorList empty
                    // - remove all anchors and their rendering
                    if (userIsDone) {
                        Context context = getApplicationContext();
                        CharSequence text = "You've already pressed done and completed making your path! You cannot undo the last arrow you put down. To make a new path, please restart the app.";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show(); }
                    else if (anchorList.isEmpty()) {
                        Context context = getApplicationContext();
                        CharSequence text = "You haven't placed down any arrows!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    else {
                    for (int i = 0; i < anchorList.size(); i++) {
                        deleteAnchor(anchorList.get(i)); }
                    anchorList.clear();
                    }
                });
        // done button // TODO: need to handle
        Button doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener(
                (unusedView) -> {
                    // done:
                    // - set userisDone to true
                    // - call saveAnchorsToCloud to save those anchors to the cloud
                    // - create ShareDialogFragment (prompt asking for user email to share with)
                    userIsDone = true;
                    saveAnchorsToCloud(anchorList);
                    //ShareDialogFragment dialog = new ShareDialogFragment();
                });
        // open/follow a path button TODO: openButton aka Follow Maps story
//        Button openButton = findViewById(R.id.open_button);
//        openButton.setOnClickListener(
//                (unusedView) -> {
//                    ShareDialogFragment dialog = new ShareDialogFragment();
//                });
    }

    private void deleteAnchor(Anchor delanchor) {
        delanchor.detach();
    }

    private String chooseCorrectModel() {
        if (anchorList.size() == 1 || userIsDone) {
            return "model_start_end.sfb";}
        else {
            return "model.sfb";
        }
    }

    // TODO: saveAnchorsToCloud method: firebase and easter egg and all that stuff
    private void saveAnchorsToCloud(ArrayList<Anchor> savetheseanchors) {}
//        System.out.print("saveAnchorsToCloud is running");
//        if (savetheseanchors.isEmpty()) {
//            Context context = getApplicationContext();
//            CharSequence text = "You haven't placed down any arrows!";
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show(); }
//        else {
//            Anchor anchor = savetheseanchors.get(0);
//            session.hostCloudAnchor(anchor);
//            String id = anchor.getCloudAnchorId();
//            CloudAnchorState state = anchor.getCloudAnchorState();
//            System.out.print("CloudID: "+id);
//            System.out.print("State: "+state.toString()); }
//    }
//        else {
//            for (int i = 0; i < savetheseanchors.size(); i++) {
//                Anchor anchor = savetheseanchors.get(i);
//                session.hostCloudAnchor(anchor);
//                String id = anchor.getCloudAnchorId();
//                CloudAnchorState state = anchor.getCloudAnchorState();
//                Context context = getApplicationContext();
//                String beginningtext = "Saving cloud ID: ";
//                String midtext = id+", state: ";
//                String endtext = state.toString();
//                CharSequence text = beginningtext + midtext + endtext;
//                int duration = Toast.LENGTH_SHORT;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();}
//            Context context = getApplicationContext();
//            CharSequence text = "Saved all";
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show(); }
//    }

    private void addModeltoScene(Anchor anchor, ModelRenderable modelRenderable)  {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode); //always add parent after addchild;
        // otherwise, scene will not bring up the child of the parent node aka the transformable node
        transformableNode.select();

    }

    private void uploadImage() {
        if(filePath != null){
            final ProgressDialog progressDialog = new ProgressDialog((this));
            progressDialog.setTitle("Saving...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/*" + UUID.randomUUID().toString());
            ref.putFile(filePath).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    progressDialog.dismiss();
                    Toast.makeText(SavedPaths.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(SavedPaths.this, "Failed to Save" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Saving your path... " + (int)progress + "%");
                }
            });
        }

    }

    public void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Path"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!= null && data.getData() != null){
            filePath = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void openGallery(){

    }


}
