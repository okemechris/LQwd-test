import unittest

class Queue:
    
    arr = []
    
    def add(self,userId):
        if userId in self.arr:
            print("Sorry, userId already exist in queue, failed")
            return
        self.arr.append(userId)
        return len(self.arr) - 1
        
    def removeUser(self,userId):
        self.arr.remove(userId)
    
    """Assumming position starts  1 """
    def removeByPosition(self,position):
        if (position - 1) > len(self.arr):
            print("Array index out of bound in remove operation, failed")
        self.arr.pop(position - 1)

    """Assumming position starts  1 """
    def move(self,fromPosition, toPosition):
        if (toPosition - 1) > len(self.arr) and (fromPosition - 1) > len(self.arr):
            print("Array index out of bound in move operation, move operation failed")
            return
        self.arr.insert(toPosition - 1, self.arr.pop(fromPosition - 1))
    
    """Assumming position starts  1 """
    def swap(self,pos1, pos2):
        if (pos1 - 1) > len(self.arr) and (pos2 - 1) > len(self.arr):
            print("Array index out of bound in swap operation, swap operation failed")
            return
        user1 = self.arr[pos1 - 1]
        user2 = self.arr[pos2 - 1]
        self.arr[pos1 - 1] = user2
        self.arr[pos2 - 1] = user1
        
        
    def reverse(self):
        self.arr.reverse()
        
    def printArr(self):
        for i in range(len(self.arr)):
            print("{0} : {1}".format(i + 1,self.arr[i]))
        

class TestURLPrint(unittest.TestCase): 
      
    def testQueue(self): 
        queue = Queue()
        queue.add(1)
        queue.add(2)
        queue.add(3)
        queue.add(4)
        queue.add(5)
        queue.swap(1,5)
        queue.printArr()
        


if __name__ == '__main__':
    unittest.main()
