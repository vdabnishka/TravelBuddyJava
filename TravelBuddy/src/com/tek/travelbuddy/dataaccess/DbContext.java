package com.tek.travelbuddy.dataaccess;

import com.tek.travelbuddy.TravelBuddyApplication;
import com.tek.travelbuddy.common.IOUtility;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbContext extends SQLiteOpenHelper {
	private Context _context;

	private static String DB_NAME = "travelBuddy";
	private static int VERSION = 1;
	
	private static String CREATE_SCRIPT_FILE_NAME = "SqlScripts/CreateDatabase.sql";
	private static String UPGRADE_SCRIPT_FILE_NAME = "SqlScripts/UpgradeTo%d.sql";
	
	public DbContext() {
		super(TravelBuddyApplication.getAppContext(), DB_NAME, null, VERSION);
		
		_context = TravelBuddyApplication.getAppContext();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		AssetManager assets = _context.getAssets();
		
		String createDb = IOUtility.ReadTextFromAssests(assets, CREATE_SCRIPT_FILE_NAME);
		execute(createDb, db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		int currentVersion = oldVersion;
		
		AssetManager assets = _context.getAssets();
		
		while (newVersion > currentVersion) {
			currentVersion++;
			String path = String.format(UPGRADE_SCRIPT_FILE_NAME, currentVersion);
			String upgradeScript = IOUtility.ReadTextFromAssests(assets, path);
			
			execute(upgradeScript, db);
		}
	}
	
	private static void execute(String script, SQLiteDatabase db) {
		String [] scripts = script.split(";");
		
		for (int i = 0; i < scripts.length; i++) {
			db.execSQL(scripts[i]);
		}
	}
}
