package com.czech.breakingbad.util

class MessageInfoQueueUtil() {
    /**
     * Does this particular GenericMessageInfo already exist in the queue? We don't want duplicates
     */
    fun doesMessageAlreadyExistInQueue(queue: Queue<MessageInfo>, messageInfo: MessageInfo): Boolean{
        for(item in queue.items){
            if (item.id == messageInfo.id){
                return true
            }
        }
        return false
    }
}