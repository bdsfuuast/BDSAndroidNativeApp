package com.fuuast.bds;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fuuast.bds.Models.BDSApi;
import com.fuuast.bds.Models.BDSApiHelper;
import com.fuuast.bds.Models.HistoryModel;
import com.fuuast.bds.Models.ProfileModel;
import com.fuuast.bds.Models.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment implements BDSApiHelper.OnApiCallFinish {
    TextView tv_user_full_name;
    TextView tv_department;
    TextView tv_contact;
    TextView tv_bloodgroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_user_full_name = view.findViewById(R.id.tv_user_full_name);
        tv_department = view.findViewById(R.id.tv_department_name);
        tv_contact = view.findViewById(R.id.tv_user_contact);
        tv_bloodgroup = view.findViewById(R.id.tv_user_bloodgroup);
        new BDSApiHelper().getProfile(view,this);
    }

    @Override
    public void OnApiCallSuccess(View view, Object data) {
        ProfileModel profile=(ProfileModel) data;
        tv_user_full_name.setText(profile.getFullName());
        tv_department.setText(profile.getDepartment());
        tv_contact.setText(profile.getContact());
        tv_bloodgroup.setText(profile.getBloodGroup());
    }

    @Override
    public void OnApiCallFail() {

    }
}
