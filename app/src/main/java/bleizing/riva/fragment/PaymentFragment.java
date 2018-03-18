package bleizing.riva.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import bleizing.riva.R;
import bleizing.riva.activity.HomecareActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {
    private final String TAG = "PaymentFragment";

    private RadioGroup rg_pembayaran;
    private RadioButton rb_cc;
    private RadioButton rb_ib;
    private RadioButton rb_sb;
    private RadioButton rb_tab;

    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rg_pembayaran = (RadioGroup) getActivity().findViewById(R.id.rg_pembayaran);

        Button btn_bayar = (Button) getActivity().findViewById(R.id.btn_bayar);
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rbChecked = (RadioButton) getActivity().findViewById(rg_pembayaran.getCheckedRadioButtonId());
                ((HomecareActivity) getActivity()).changeToPemesananFragment();
            }
        });
    }
}
