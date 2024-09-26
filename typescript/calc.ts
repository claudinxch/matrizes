const matriz1: number[][] = []
const matriz2: number[][] = []

const n = parseInt(prompt('Digite o tamanho das matrizes quadrada:') as string)

const renderMultidimensionalArray = (arr: number[][], length: number): void => {
    for (let i = 0; i < length; i++){
        const row: number[] = []
        for (let j = 0; j < length; j++){
            const value = parseInt(prompt(`Digite o ${j + 1}º valor da ${i + 1} linha da matriz.`) as string)
            row.push(value)
        }
        arr.push(row)
    }
}

const sumMatrices = (arr1: number[][], arr2: number[][]): number[][] => {
    return arr1.map((row, i) => row.map((value, j) => value + arr2[i][j]))
}

const multiplyMatrices = (arr1: number[][], arr2: number[][]): number[][] => {
    const multipliedArr: number[][] = []

    for (let i = 0; i < arr1.length; i++) {
      const row : number[] = []
      for (let j = 0; j < arr2[0].length; j++){
        let sum = 0
        for(let k = 0; k < arr2.length; k++){
          sum += arr1[i][k] * arr2[k][j]
        }
        row.push(sum)
      }
      multipliedArr.push(row)
    }

    return multipliedArr
}

renderMultidimensionalArray(matriz1, n)
alert('Agora para a segunda matriz...')
renderMultidimensionalArray(matriz2, n)

const sumOfMatrixs = sumMatrices(matriz1, matriz2)
const multiplicationOfMatrixs = multiplyMatrices(matriz1, matriz2)

console.log(sumOfMatrixs)
console.log(multiplicationOfMatrixs)