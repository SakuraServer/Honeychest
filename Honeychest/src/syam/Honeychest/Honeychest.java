package syam.Honeychest;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Honeychest extends JavaPlugin{
	public final static Logger log = Logger.getLogger("Minecraft");
	public final static String logPrefix = "[Honeychest] ";
	public final static String msgPerfix = "&c[Honeychest] &f";

	private static Honeychest instance;

	/**
	 * プラグイン停止処理
	 */
	public void onDisable(){
		// メッセージ表示
		PluginDescriptionFile pdfFile=this.getDescription();
		log.info("Honeychest ["+pdfFile.getName()+"] version "+pdfFile.getVersion()+" is disabled!");
	}

	/**
	 * プラグイン起動処理
	 */
	public void onEnable(){
		instance = this;

		// コマンドを登録
		getServer().getPluginCommand("honeychest").setExecutor(new HoneychestCommand());
		log.info(logPrefix+"Initialized Command.");

		// メッセージ表示
		PluginDescriptionFile pdfFile=this.getDescription();
		log.info("SakuraServerPlugin ["+pdfFile.getName()+"] version "+pdfFile.getVersion()+" is enabled!");
	}

	/**
	 * シングルトンパターンでない/ プラグインがアンロードされたイベントでnullを返す
	 * @return シングルトンインスタンス 何もない場合はnull
	 */
	public static Honeychest getInstance() {
    	return instance;
    }
}
