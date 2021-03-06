package com.example.administrator.lsys_camera.filter;

import android.content.Context;

import com.example.administrator.lsys_camera.LSYSUtility;
import com.example.administrator.lsys_camera.R;

public class SimpleGreen3Filter extends Filter {
    private int program;
    private int texture2Id,texture3Id,texture4Id;

    public SimpleGreen3Filter(Context context) {
        super(context);

        // Build shaders
        program = LSYSUtility.buildProgram(context, R.raw.vertext, R.raw.simple_green3);

        // Load the texture will need for the shader
        texture2Id = LSYSUtility.loadTexture(context, R.raw.tex11, new int[2]); // 타일
        texture3Id = LSYSUtility.loadTexture(context, R.raw.tex11, new int[2]); // 배경
        texture4Id = LSYSUtility.loadTexture(context, R.raw.tex11, new int[2]);  // 모자이크
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId,texture3Id,texture2Id,texture4Id},
                new int[][]{});
    }
}
