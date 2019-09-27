package fr.vsct.tock.bot

import fr.vsct.tock.bot.api.client.newBot
import fr.vsct.tock.bot.api.client.newStory
import fr.vsct.tock.bot.api.client.unknownStory
import fr.vsct.tock.bot.api.websocket.start
import fr.vsct.tock.bot.connector.messenger.buttonsTemplate
import fr.vsct.tock.bot.connector.messenger.nlpQuickReply

fun main() {
    start(
            newBot(
                    //clé de l'API
                    "xxxxxxxxxxxxxxxxxxxxxxxx",
                    //réponse simple ,correspondant à l'intention greetings
                    newStory("greetings") {
                        end("Coucou")
                    },
                    //réponse sous format card correspondant à l'intention location
                    newStory("location") {
                        end(
                                newCard(
                                        "Titre",
                                        "Sous-Titre",
                                        newAttachment("https://url-image.png"),
                                        newAction("Action 1"),
                                        newAction("Action 2", "http://redirection")
                                )
                        )
                    },
                    //réponse sous format spécifique au canal (ici messenger)
                    //correspondant à l'intention goodbye
                    newStory("goodbye") {
                        end {
                            buttonsTemplate("Mais pourquoi?", nlpQuickReply("Je ne veux pas partir"))
                        }
                    },
                    //réponse renvoyée quand l'intention n'est pas répertoriée
                    unknownStory {
                        end("je n'ai pas compris")
                    }
            ))
}
