class Solution(object):
    def setZeroes(self, matrix):
        row=[]
        col=[]
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j]==0:
                    row.append(i)
                    col.append(j)       
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if i in row or j in col:
                    matrix[i][j]=0
                        
                    