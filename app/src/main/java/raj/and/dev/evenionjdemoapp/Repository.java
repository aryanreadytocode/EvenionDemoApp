package raj.and.dev.evenionjdemoapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Raj Aryan on 12/30/2020.
 * Mahiti Infotech
 * raj.aryan@mahiti.org
 */
public class Repository {

    private static List<DataModel> dataModels = new ArrayList<>();

    public static void insertData(DataModel dataModel){
      dataModels.add(dataModel);
    }

    public static void delete(DataModel task) {
        for (DataModel dm:dataModels) {
            if (dm.getUuid().equals(task.getUuid())) {
                dataModels.remove(dm);
            }
        }
    }

    public static void update(DataModel task) {
        for (DataModel dataModel:dataModels){
            if (dataModel.getUuid().equals(task.getUuid())){
                dataModels.remove(dataModel);
                dataModels.add(task);
            }
        }

    }

    public static List<DataModel> getAll() {
        return dataModels;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getImage(Uri selectedImage, Context context) {
        String imagePath=null;
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        if (selectedImage != null) {
            Cursor cursor = context.getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);
                cursor.close();
            }
        }
        return imagePath;
    }
}
