import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class HiProBud extends ListenerAdapter {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createDefault(Token.token, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_MESSAGES);
        HiProBud bot = new HiProBud();
        bot.builderConfig(builder);
        builder.addEventListeners(bot);
        builder.build().awaitReady();
        System.out.println("Bot started! ");

    }
    public void builderConfig( JDABuilder builder){
        builder.setActivity(Activity.watching("over Pros"));
       // builder.disableCache(CacheFlag.MEMBER_OVERRIDES);
       // builder.setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.ONLINE));
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        System.out.println("Got message:"+msg.getContentRaw());
        if(msg.getContentRaw().equals("!hi")){
            MessageChannel channel = event.getChannel();
            channel.sendMessageFormat("Hi %s",event.getAuthor().getName()).queue();
            System.out.println("Hi sent back!");
        }

    }
}
