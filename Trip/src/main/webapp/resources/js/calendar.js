/*Selector Range*/
class Range extends React.Component {
    constructor(props) {
        super(props);
        this.monthNames = ["1월", "2월", "3월", "4월", "5월", "6월",
            "7월", "8월", "9월", "10월", "11월", "12월"];
        this.daysNames = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
    }
    dateInfo(date){
        let dateRow;
        let rangeMonthText = 'Choose a date';
        if(date){
            dateRow = React.createElement('td', { rowSpan: '2' }, React.createElement('span', { className: 'calendar__range-date' }, date.getDate()));
            rangeMonthText = this.monthNames[date.getMonth()]+' '+ date.getFullYear();
        }
        return (
            React.createElement('tr', null,
                dateRow,
                React.createElement('td', null,
                    React.createElement('span', { className: "calendar__range-month" },
                        rangeMonthText
                    )
                )
            )
        );
    }
    dumbDate(date, title){
        let day = (date)?(React.createElement('tr', null,
            React.createElement('td', null,
                React.createElement('span', { className: 'calendar__range-day' }, this.daysNames[date.getDay()])
            )
        )):null;
        return (React.createElement('div', { className: 'calendar__from-date' },
            React.createElement('table', null,
                React.createElement('tbody', null,
                    React.createElement('tr', null,
                        React.createElement('td', { colSpan: '2' },
                            React.createElement('span', { className: 'calendar__range-h' }, title)
                        )
                    ),
                    this.dateInfo(date),
                    day
                )
            )
        ));
        console.log(day)
        console.log(date)
    }
    render() {
        let {dateFrom, dateTo} = this.props;
        dateTo = dateTo ? new Date(dateTo) : dateTo;
        dateFrom = dateFrom ? new Date(dateFrom) : dateFrom;
        return (React.createElement('div', { className: 'calendar__range' },
            this.dumbDate(dateFrom,'시작 날'),
            React.createElement('div', { className: 'calendar__image-arrow' },
                React.createElement('span', null, "\u2192")
            ),
            this.dumbDate(dateTo,'마지막 날')
        ));
    }
}
/*Header Table*/
class Header extends React.Component {
    constructor(props) {
        super(props);
        this.monthNames = ["1월", "2월", "3월", "4월", "5월", "6월",
            "7월", "8월", "9월", "10월", "11월", "12월"];
        this.dayNames = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN'];
    }
    shouldComponentUpdate(nextProps){
        return nextProps.date != this.props.date;
    }
    render() {
        let date  = new Date(this.props.date);
        return (React.createElement('div', { className: 'calendar__header' },
            React.createElement('div', { className: 'calendar__month-chooser' },
                React.createElement('span', { className: 'calendar__prev-month', onClick: this.props.prevMonth }, "\u2B80"),
                React.createElement('span', null, this.monthNames[date.getMonth()]),
                React.createElement('span', { className: 'calendar__next-month', onClick: this.props.nextMonth }, "\u27A1")
            ),
            React.createElement('table', { className: 'calendar__days-names', cellSpacing: '0' },
                React.createElement('tbody', null,
                    React.createElement('tr', null,
                        this.dayNames.map((i, key)=> React.createElement('td', { className: 'calendar__day-name', key: key }, i))
                    )
                )
            )
        ));
    }
}

/*Calendar Table*/
/*Calendar Table*/
class Calendar extends React.Component{
    constructor(props){
        super(props);
        this.selectionEnabled = false;
        this.shortMonthNames = ['Jan','Feb','Mar','Apr','May','June','July','Aug','Sept','Oct','Nov','Dec']
        this.currentDate = new Date();
        this.state = {
            animationDirection: "forward" // animationDirection 초기화
        };
    }
    handleClick(index){
        let {setRange, indexStart, indexEnd} = this.props;
        if(this.selectionEnabled ){
            if((index == indexStart)){
                this.selectionEnabled = false;
                setRange();
            }else{
                this.selectionEnabled = false;
                setRange(this.props.indexStart, index);
            }
        }else{
            if(index == indexEnd){
                this.selectionEnabled = true;
            }else{
                this.selectionEnabled = true;
                setRange(index);
            }
        }
    }
    mouseOver(index){
        if(this.selectionEnabled){
            this.props.setRange(this.props.indexStart, index);
        }
    }
    componentDidUpdate(prevProps, prevState) {
        if (prevProps.animationDirection !== this.props.animationDirection) { // 수정
            const calendar = document.querySelector('.calendar__table');
            const { animationDirection } = this.props; // 수정

            if (animationDirection === 'forward') {
                calendar.classList.add('animate--forward');
                calendar.classList.remove('animate--backward');
            } else if (animationDirection === 'backward') {
                calendar.classList.add('animate--backward');
                calendar.classList.remove('animate--forward');
            }
        }
    }
    getDay(date, key, month){
        let time = date.getTime();
        let currentDate = this.currentDate;
        let {indexEnd, indexStart} = this.props;
        let dayClass = (time > indexStart && time < indexEnd) ? 'selected' : '';
        dayClass += ( date < currentDate.setHours(0)) ?' out--range':'';
        dayClass += (time == indexStart && indexEnd > indexStart) ? ' sel--start' : '';
        dayClass += (time == indexEnd && time > indexStart) ? ' sel--end' : '';
        dayClass += (date.getMonth() == month)?' calendar__day':' calendar__day dis';
        return(React.createElement('td', { className: dayClass,
            onClick: this.handleClick.bind(this, time),
            onMouseOver: this.mouseOver.bind(this,time),
            key: key },
            React.createElement('div', { className: 'calendar__inner-day' }, date.getDate())
        ));
    }
    render(){
        let date  = new Date(this.props.date);
        let month = date.getMonth();
        date.setDate(1);
        if(this.animationDirection == "forward"){
            date.setMonth(date.getMonth() - 1);
        }
        let firstDay = date.getDay();
        if(firstDay !== 1){
            (firstDay == 0)?
                date.setDate(date.getDate() - 6)
                :date.setDate(date.getDate() - (firstDay - 1));
        }
        date.setDate(date.getDate() - 1);
        return(React.createElement('div', { className: 'calendar__wrap' },
            React.createElement('table', { className: 'calendar__table', ref: 'calendar', key: this.props.date, cellSpacing: '0' },
                React.createElement('tbody', null,
                    Array(12).fill(0).map((i, key)=> {
                        return React.createElement('tr', { key: key },
                            Array(7).fill(0).map((_i, _key)=> {
                                date.setDate(date.getDate() + 1);
                                return this.getDay(date, _key, month);
                            })
                        );
                    })
                )
            )
        ));
    }
}


/*Smart Component*/
class APP extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            date:Date.now(),
            selectionStart: 0,
            selectionEnd: 0
        }
    }
    prevMonth(){
        let date = new Date(this.state.date);
        date.setMonth(date.getMonth() - 1);
        this.setState({date:date.getTime()});
    }
    nextMonth(){
        let date = new Date(this.state.date);
        date.setMonth(date.getMonth() + 1);
        this.setState({date:date.getTime()});
    }
    setRange(selectionStart = 0, selectionEnd = 0){
    	
        this.setState({selectionStart, selectionEnd});

    }  handleDaySelection() {
        let { selectionStart, selectionEnd } = this.state;
        console.log("시작 날" + selectionStart);
        console.log("끝나는 날" + selectionEnd);
        // 여기에 선택한 날짜로 할 일을 추가하세요
    }
    render(){

        let {date, selectionStart, selectionEnd} = this.state;
        return (React.createElement('div', { className: 'calendar' },
            React.createElement(Range, { dateFrom: selectionStart, dateTo: selectionEnd }),
            React.createElement(Header, { date: date, prevMonth: this.prevMonth.bind(this), nextMonth: this.nextMonth.bind(this) }),
            React.createElement(Calendar, { date: date, indexStart: selectionStart, indexEnd: selectionEnd, setRange: this.setRange.bind(this) }),
              React.createElement('button', { id: 'selectDay',type:'button', onClick: this.handleDaySelection.bind(this) }, '선택한 날짜 확인')
              
        ));
    }
    
}

ReactDOM.render(React.createElement(APP, null), document.querySelector('#app'));