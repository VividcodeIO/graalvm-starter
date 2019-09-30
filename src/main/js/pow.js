const http = require('http')
const url = require('url')
const port = 3000
const BigInteger = Java.type('java.math.BigInteger')

const requestHandler = (request, response) => {
  try {
    const {query} = url.parse(request.url, true)
    const {base, exponent} = query
    const result = (new BigInteger(base)).pow(parseInt(exponent, 10))
    response.end(result.toString())
  } catch (e) {
    console.error(e)
    response.end(e.message)
  }
}

const server = http.createServer(requestHandler)

server.listen(port, (err) => {
  if (err) {
    return console.log('Error', err)
  }

  console.log(`server is listening on ${port}`)
})