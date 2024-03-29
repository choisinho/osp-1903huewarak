package app.bqlab.huewarak;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

public class MainActivity extends AppCompatActivity {

    //variables
    String input = "0";
    int point = 5000;
    boolean deviceConnected;
    //objects
    BluetoothSPP mBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_CANCELED) {
        } else {
            switch (requestCode) {
                case BluetoothState.REQUEST_ENABLE_BT:
                    mBluetooth.connect(Objects.requireNonNull(data));
                    break;
            }
        }
    }

    private void init() {
        //initialize
        mBluetooth = new BluetoothSPP(this);
        //setup
        ((TextView) findViewById(R.id.main_top_point)).setText(String.valueOf(point));
        findViewById(R.id.main_top_connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConnectionDialog();
            }
        });
        findViewById(R.id.main_bot_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() > 0) {
                    input += ((Button) v).getText().toString();
                    ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                }
            }
        });
        findViewById(R.id.main_bot_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.charAt(0) == '0')
                    input = "";
                input += ((Button) v).getText().toString();
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
            }
        });
        findViewById(R.id.main_bot_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() > 1) {
                    input = input.substring(0, input.length() - 1);
                    ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                } else {
                    input = "0";
                    ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                }
            }
        });
        findViewById(R.id.main_bot_back).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                input = "0";
                ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                return false;
            }
        });
        findViewById(R.id.main_bot_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i = Integer.parseInt(input);
                    if (i > 0 && i <= 1000000) {
                        point += i;
                        input = "0";
                        ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                        ((TextView) findViewById(R.id.main_top_point)).setText(String.valueOf(point));
                    } else {
                        showToastInCenter("0과 100만 사이의 수를 입력해주세요.");
                    }
                } catch (NumberFormatException e) {
                    showToastInCenter("0과 100만 사이의 수를 입력해주세요.");
                }
            }
        });
        findViewById(R.id.main_bot_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i = Integer.parseInt(input);
                    if (i > 0 && i <= 1000000) {
                        point -= i;
                        input = "0";
                        ((TextView) findViewById(R.id.main_bot_input)).setText(input);
                        ((TextView) findViewById(R.id.main_top_point)).setText(String.valueOf(point));
                    } else {
                        showToastInCenter("0과 100만 사이의 수를 입력해주세요.");
                    }
                } catch (NumberFormatException e) {
                    showToastInCenter("0과 100만 사이의 수를 입력해주세요.");
                }
            }
        });
    }

    private void connectToDevice() {
        if (!mBluetooth.isBluetoothAvailable()) {
            showToastInCenter("블루투스를 지원하지 않는 기기입니다.");
            finishAffinity();
        } else if (!mBluetooth.isBluetoothEnabled()) {
            showToastInCenter("블루투스가 활성화되지 않았습니다.");
        } else if (!mBluetooth.isServiceAvailable()) {
            mBluetooth.setupService();
            mBluetooth.startService(BluetoothState.DEVICE_OTHER);
            connectToDevice();
        } else {
            mBluetooth.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
                @Override
                public void onDataReceived(byte[] data, String message) {
                    deviceConnected = true;
                    point += Integer.parseInt(message);
                }
            });
            mBluetooth.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
                @Override
                public void onDeviceConnected(String name, String address) {
                    showToastInCenter("연결되었습니다.");
                }

                @Override
                public void onDeviceDisconnected() {
                    deviceConnected = false;
                    showToastInCenter("연결되지 않았습니다.");
                }

                @Override
                public void onDeviceConnectionFailed() {
                    deviceConnected = false;
                    showToastInCenter("연결되지 않았습니다.");
                }
            });
            startActivityForResult(new Intent(MainActivity.this, DeviceList.class), BluetoothState.REQUEST_ENABLE_BT);
        }
    }

    private void showConnectionDialog() {
        if (deviceConnected) {
            new AlertDialog.Builder(this)
                    .setMessage("장치와 연결되어 있습니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("장치와 연결되어 있지 않습니다. 장치와 페어링 후 앱과 연결하세요.")
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("연결", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            connectToDevice();
                        }
                    })
                    .setNeutralButton("장치와 페어링하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS));
                        }
                    }).show();
        }
    }

    private void showToastInCenter(String message) {
        Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
