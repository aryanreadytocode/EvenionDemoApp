package raj.and.dev.evenionjdemoapp;

import android.net.Uri;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Raj Aryan on 12/30/2020.
 * Mahiti Infotech
 * raj.aryan@mahiti.org
 */
public class DataModel implements Serializable {
    private String label;
    private String  uuid;
    private String description;
    private Uri filePath;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getFilePath() {
        return filePath;
    }

    public void setFilePath(Uri filePath) {
        this.filePath = filePath;
    }
}
