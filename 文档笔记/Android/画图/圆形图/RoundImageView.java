package com.example.administrator.testroundimage;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;


/**
 *自定义圆形头像
 */
public class RoundImageView extends ImageView {
    private Bitmap bitmap;
    private int width = 100;
    private BitmapShader bitmapShader;
    private ShapeDrawable shapeDrawable;
    private Paint paintBitmap;
    private Matrix matrix;

    /**
     * @param context
     * @param attrs
     */
    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setScaleType(ScaleType.CENTER_CROP);
        // TODO Auto-generated constructor stub
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.dddd))
                .getBitmap();
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);//
        paintBitmap = new Paint();
        paintBitmap.setAntiAlias(true);
        paintBitmap.setFilterBitmap(true);
        paintBitmap.setShader(bitmapShader);//给画笔设置shader  相当于笔的颜色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        matrix = new Matrix();
        matrix.set(null);
        float scale = 0, tx = 0, ty = 0;


        if (bitmap.getWidth()-10 > bitmap.getHeight()) {
            scale = (float) (getHeight()-10) / bitmap.getHeight();
                   tx = (float) (getWidth()-10 - bitmap.getWidth() * scale) / 2;

        } else {
            scale = (float) (getWidth()-10) / bitmap.getWidth();
            ty = (getHeight()-10 - bitmap.getHeight() * scale) * 0.5f;

        }
        matrix.setScale(scale, scale);//设置缩放
        matrix.postTranslate(tx + 0.0f, ty + 0.0f);//设置移动  缩放和移动 保证图片填充及截取图片正中央显示圆形
        bitmapShader.setLocalMatrix(matrix);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2-10, paintBitmap);

        //画外面的圆
        Paint paintCycle=new Paint();
        paintCycle.setColor(getResources().getColor(R.color.accent_material_light));
        paintCycle.setAntiAlias(true);
        paintCycle.setStyle(Paint.Style.STROKE);
        paintCycle.setStrokeWidth(10);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getHeight()/2-10,paintCycle);
    }
}
