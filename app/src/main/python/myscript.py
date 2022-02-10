from nltk.chat.util import chat

def main(inputData):

    pairs = [
        ["my name is jay",["hey jay"]],
        ["how are you",["i am fine what about you?"]],
        ["what is data of projection",["20-12-2000"]]
    ]

    chat = Chat(pairs)

    outputdata = chat.respond(inputData)



    return ""+str(outputdata)
