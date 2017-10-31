/** 
 *  Format the article posting time
 */
exports.customTime = item => {
    let nowTime = new Date().getTime()
    let minuteTime = 60 * 1000
    let hourTime = 60 * minuteTime
    let dayTime = 24 * hourTime
    let monthTime = dayTime * 30
    let yearTime = monthTime * 12

    let publishTime = new Date(item).getTime()
    let historyTime = parseInt(nowTime) - parseInt(publishTime)
    let descTime
    if (historyTime >= yearTime) {
        //Yearly
        descTime = parseInt(historyTime / yearTime) + ' years ago'
    } else if (historyTime < yearTime && historyTime >= monthTime) {
        //Monthly count
        descTime = parseInt(historyTime / monthTime) + ' month ago'
    } else if (historyTime < monthTime && historyTime >= dayTime) {
        //Count by day
        descTime = parseInt(historyTime / dayTime) + ' days ago'
    } else if (historyTime < dayTime && historyTime >= hourTime) {
        //Count in hours
        descTime = parseInt(historyTime / hourTime) + ' hours ago'
    } else if (historyTime < hourTime && historyTime >= minuteTime) {
        //Count in minutes
        descTime = parseInt(historyTime / minuteTime) + ' minutes ago'
    } else {
        descTime = '刚刚'
    }
    return descTime
}

exports.formatDate = time => {
    let tmpDate = new Date(time)
    let year = tmpDate.getFullYear()
    let mathon = tmpDate.getMonth() + 1
    let day = tmpDate.getDate()
    let hours = tmpDate.getHours()
    let minutes = tmpDate.getMinutes()
    return year + '.' + mathon + '.' + day + ' ' + hours + ':' + minutes
}