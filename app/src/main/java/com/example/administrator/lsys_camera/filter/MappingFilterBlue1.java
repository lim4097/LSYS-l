package com.example.administrator.lsys_camera.filter;

import android.content.Context;

import com.example.administrator.lsys_camera.LSYSUtility;
import com.example.administrator.lsys_camera.R;

public class MappingFilterBlue1 extends Filter {
    private int program;
    private int texture2Id;

    public MappingFilterBlue1(Context context) {
        super(context);

        // Build shaders
        program = LSYSUtility.buildProgram(context, R.raw.vertext, R.raw.mapping);

        // Load the texture will need for the shader
        texture2Id = LSYSUtility.loadTexture(context, R.raw.texmap_blue1, new int[2]);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId, texture2Id},
                new int[][]{});
    }
}

