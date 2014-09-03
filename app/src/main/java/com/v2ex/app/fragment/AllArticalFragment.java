package com.v2ex.app.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Response;
import com.v2ex.app.R;
import com.v2ex.app.utils.UIHelper;
import com.v2ex.app.model.User;
import com.v2ex.app.network.V2Request;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllArticalFragment extends Fragment {

    public AllArticalFragment() {
        // Required empty public constructor
    }

    @InjectView(R.id.list) ListView mListView;
    @InjectView(R.id.btn) Button mButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_latest, container, false);
        ButterKnife.inject(this, root);
        return root;
    }

    @OnClick(R.id.btn) public void fetch() {
//        V2Request.fetchAllArtical(new Response.Listener<List<Artical>>() {
//            @Override public void onResponse(List<Artical> articals) {
//                L.d(articals.toArray().toString());
//            }
//        });
        V2Request.getUserInfo(1, new Response.Listener<User>() {
            @Override public void onResponse(User user) {
                UIHelper.showToast(getActivity(), user.getBio());
            }
        });
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
