package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;


public class PhotoFragment extends DialogFragment {

    public static final String ARG_PHOTO = "photo";

    private String mPhotoFilePath;
    private ImageView mImageView;

    public static PhotoFragment newInstance(String photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photoFile);

        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(args);

        return photoFragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mPhotoFilePath = (String) getArguments().getSerializable(ARG_PHOTO);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_photo_image_view);
        mImageView.setImageBitmap(PictureUtils.getScaledBitmap(mPhotoFilePath, getActivity()));

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
