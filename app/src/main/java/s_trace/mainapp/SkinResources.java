package s_trace.mainapp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;

import java.io.InputStream;

public final class SkinResources {
    private static Context sContext;
    private static Context sSkinContext;
    private static Resources sResources;
    private static Resources sSkinResources;
    private static String TAG = "SkinResources";
    private static String sSkinPackage;

    public static void initialize(Context context) {
        if (sSkinPackage != null) {
            sContext = context;
            sResources = sContext.getResources();
            try {
                sSkinContext = sContext.createPackageContext(sSkinPackage, Context.CONTEXT_IGNORE_SECURITY);
                sSkinResources = sSkinContext.getResources();
            } catch (PackageManager.NameNotFoundException e) {
                Log.w(TAG, "Unable to create context for skin package '" + TAG + "': " + e);
            }
        } else {
            Log.e(TAG, "sSkinPackage is null - please call sSkinPackage(String packageName) before calling initialize(Context context)");
        }
    }

    public static String getSkinPackage() {
        return sSkinPackage;
    }

    public static void setSkinPackage(String newSkinPackage) {
        sSkinPackage = newSkinPackage;
    }

    public static Context getsSkinContext() {
        Context res = sContext;
        if(sSkinContext != null)
            res = sSkinContext;
        return res;
    }

    private static int getSkinResourceId(String resourceEntryName, String resourceType) {
        return sSkinResources.getIdentifier(resourceEntryName, resourceType, sSkinPackage);
    }

    public static XmlResourceParser getAnimation(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        XmlResourceParser res;

        // Check is resource id valid
        try {
            res = sResources.getAnimation(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getAnimation(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static AssetManager getAssets() throws Resources.NotFoundException {
        AssetManager res;
        // Get own package AssetManager
        res = sResources.getAssets();
        if (sSkinResources != null) {
            // Try to get AssetManager from skin package
            res = sSkinResources.getAssets();
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static boolean getBoolean(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        boolean res;

        // Check is resource id valid
        try {
            res = sResources.getBoolean(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getBoolean(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getColor(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int res;

        // Check is resource id valid
        try {
            res = sResources.getColor(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getColor(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getColor(int resid, Resources.Theme theme) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int res;

        // Check is resource id valid
        try {
            res = sResources.getColor(resid, theme);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getColor(id, theme);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static ColorStateList getColorStateList(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        ColorStateList res;

        // Check is resource id valid
        try {
            res = sResources.getColorStateList(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getColorStateList(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static ColorStateList getColorStateList(int resid, Resources.Theme theme) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        ColorStateList res;

        // Check is resource id valid
        try {
            res = sResources.getColorStateList(resid, theme);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getColorStateList(id, theme);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static float getDimension(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        float res;

        // Check is resource id valid
        try {
            res = sResources.getDimension(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDimension(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getDimensionPixelOffset(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int res;

        // Check is resource id valid
        try {
            res = sResources.getDimensionPixelOffset(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDimensionPixelOffset(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getDimensionPixelSize(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int res;

        // Check is resource id valid
        try {
            res = sResources.getDimensionPixelSize(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDimensionPixelSize(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Drawable getDrawable(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Drawable res;

        // Check is resource id valid
        try {
            res = sResources.getDrawable(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDrawable(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Drawable getDrawable(int resid, Resources.Theme theme) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Drawable res;

        // Check is resource id valid
        try {
            res = sResources.getDrawable(resid, theme);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDrawable(id, theme);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Drawable getDrawableForDensity(int resid, int density) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Drawable res;

        // Check is resource id valid
        try {
            res = sResources.getDrawableForDensity(resid, density);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDrawableForDensity(id, density);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Drawable getDrawableForDensity(int resid, int density, Resources.Theme theme) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Drawable res;

        // Check is resource id valid
        try {
            res = sResources.getDrawableForDensity(resid, density, theme);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getDrawableForDensity(id, density, theme);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Typeface getFont(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Typeface res;

        // Check is resource id valid
        try {
            res = sResources.getFont(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getFont(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static float getFraction(int resid, int base, int pbase) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        float res;

        // Check is resource id valid
        try {
            res = sResources.getFraction(resid, base, pbase);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getFraction(id, base, pbase);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int[] getIntArray(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int[] res;

        // Check is resource id valid
        try {
            res = sResources.getIntArray(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getIntArray(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getIdentifier(int resid) {
        String resourceType;
        String resourceEntryName;
        int res;
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            res = getSkinResourceId(resourceEntryName, resourceType);
        } else {
            res = resid;
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static int getInteger(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int res;

        // Check is resource id valid
        try {
            res = sResources.getInteger(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getInteger(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static XmlResourceParser getLayout(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        XmlResourceParser res;

        // Check is resource id valid
        try {
            res = sResources.getLayout(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getLayout(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static Movie getMovie(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        Movie res;

        // Check is resource id valid
        try {
            res = sResources.getMovie(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getMovie(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static String getQuantityString(int resid, int quantity) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        String res;

        // Check is resource id valid
        try {
            res = sResources.getQuantityString(resid, quantity);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getQuantityString(id, quantity);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static String getQuantityString(int resid, int quantity, Object... formatArgs) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        String res;

        // Check is resource id valid
        try {
            res = sResources.getQuantityString(resid, quantity, formatArgs);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getQuantityString(id, quantity, formatArgs);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static CharSequence getQuantityText(int resid, int quantity) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        CharSequence res;

        // Check is resource id valid
        try {
            res = sResources.getQuantityText(resid, quantity);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getQuantityText(id, quantity);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static String getString(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        String res;

        // Check is resource id valid
        try {
            res = sResources.getString(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getString(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static String getString(int resid, Object... formatArgs) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        String res;

        // Check is resource id valid
        try {
            res = sResources.getString(resid, formatArgs);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getString(id, formatArgs);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static String[] getStringArray(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        String[] res;

        // Check is resource id valid
        try {
            res = sResources.getStringArray(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getStringArray(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static CharSequence getText(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        CharSequence res;

        // Check is resource id valid
        try {
            res = sResources.getText(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getText(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static CharSequence getText(int resid, CharSequence def) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        CharSequence res;

        // Check is resource id valid
        try {
            res = sResources.getText(resid, def);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getText(id, def);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static CharSequence[] getTextArray(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        CharSequence[] res;

        // Check is resource id valid
        try {
            res = sResources.getTextArray(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getTextArray(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static void getValue(int resid, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int id = 0;
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                sSkinResources.getValue(id, outValue, resolveRefs);
        }
        if (id == 0) {
            try {
                sResources.getValue(resid, outValue, resolveRefs);
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Resource " + resid + " not found: ", e);
                throw e;
            }
            Log.v(TAG, "sSkinResources = null");
        }
    }

    public static void getValue(String name, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        boolean success = false;
        if (sSkinResources != null) {
            // Try to get resource with same type and name from skin package
            try {
                sSkinResources.getValue(name, outValue, resolveRefs);
                success = true;
            } catch (Resources.NotFoundException e) {
                Log.v(TAG, "getValue(String name, TypedValue outValue, boolean resolveRefs) failed for skin package", e);
            }
        }
        if (success = false) {
            try {
                Log.v(TAG, "sSkinResources = null");
                sResources.getValue(name, outValue, resolveRefs);
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Resource " + name + " not found: ", e);
                throw e;
            }
        }
    }

    public static void getValueForDensity(int resid, int density, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        int id = 0;
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                sSkinResources.getValueForDensity(id, density, outValue, resolveRefs);
        }
        if (id == 0) {
            try {
                sResources.getValueForDensity(resid, density, outValue, resolveRefs);
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Resource " + resid + " not found: ", e);
                throw e;
            }
            Log.v(TAG, "sSkinResources = null");
        }
    }

    public static XmlResourceParser getXml(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        XmlResourceParser res;

        // Check is resource id valid
        try {
            res = sResources.getXml(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.getXml(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static TypedArray obtainTypedArray(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        TypedArray res;

        // Check is resource id valid
        try {
            res = sResources.obtainTypedArray(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.obtainTypedArray(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static InputStream openRawResource(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        InputStream res;

        // Check is resource id valid
        try {
            res = sResources.openRawResource(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.openRawResource(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static InputStream openRawResource(int resid, TypedValue value) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        InputStream res;

        // Check is resource id valid
        try {
            res = sResources.openRawResource(resid, value);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.openRawResource(id, value);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }

    public static AssetFileDescriptor openRawResourceFd(int resid) throws Resources.NotFoundException {
        String resourceType;
        String resourceEntryName;
        AssetFileDescriptor res;

        // Check is resource id valid
        try {
            res = sResources.openRawResourceFd(resid);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Resource " + resid + " not found: ", e);
            throw e;
        }
        if (sSkinResources != null) {
            // Get resource description from base package
            resourceType = sResources.getResourceTypeName(resid);
            resourceEntryName = sResources.getResourceEntryName(resid);
            Log.v(TAG, "Resource " + resid + " have resourceType=" + resourceType + " and resourceEntryName=" + resourceEntryName);

            // Try to get resource with same type and name from skin package
            int id = getSkinResourceId(resourceEntryName, resourceType);
            if (id != 0)
                res = sSkinResources.openRawResourceFd(id);
        } else {
            Log.v(TAG, "sSkinResources = null");
        }
        return res;
    }
}
