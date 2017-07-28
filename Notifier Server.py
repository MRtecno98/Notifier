import bottle , json , pprint , telepot , threading

chats = []

@bottle.route("/json=<jsonTxt>")
def index(jsonTxt) :
    obj = json.loads(jsonTxt)
    if obj["season"] == "ban" :
        message = "Il player " + obj["target"] + " è stato bannato da " + obj["sender"] + "."
    elif obj["season"] == "kick" :
        message = "Il player " + obj["target"] + " è stato kickato da " + obj["sender"] + "."
    for chat_id in chats :
        bot.sendMessage(chat_id , message)
        print("Message sended at: " + str(chat_id))
    

    return "Status: OK, Message sended correctely"

@bottle.route("/")
def root() :
    return "Hello!"

def response(msg) :
    chat_id = msg["chat"]["id"]
    text = msg["text"]

    if text == "/start" :
        chats.append(chat_id)
        print("Registered Chat ID: " + str(chat_id))

    if text == "/stop" :
        chats.remove(chat_id)
        print("Unregistered Chat ID: " + str(chat_id))

def startServer() :
    bottle.run(host="localhost", port=8080)

bot = telepot.Bot("435817204:AAFVpZ3okQm1zubukV0_yiPPJQu60WJGMKo")
server = threading.Thread(target=startServer)
bot.message_loop(response)
server.run()




