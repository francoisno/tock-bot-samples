import fr.vsct.tock.bot.api.client.newBot
import fr.vsct.tock.bot.api.client.newStory
import fr.vsct.tock.bot.api.websocket.start

fun main() {
    start(
            newBot(
                    "xxxxxxxxxxxxxxxxxxxx", // Your Tock app API key
                    newStory("qui-es-tu") { // Answer for the 'quitter' story
                        send("Je suis un assistant conversationnel construit avec Tock")
                        end("Comment puis-je aider ?")
                    },
                    newStory("test") { // Answer for the 'quitter' story
                        end("OK")
                    }
            ),
            "http://localhost:8080")
}